#!/bin/bash
source ../commons/commons.sh
echo ">> Building...";

DIRECTORY=$(basename ${PWD});
CUSTOM_SETTINGS_GRADLE_FILE="../settings.gradle.all";

IS_CI=false;
if [[ ! -z "${CI}" ]]; then
	IS_CI=true;
fi
echo "$DIRECTORY/build.sh > IS_CI:'${IS_CI}'";

GRADLE_ARGS="";
if [ ${IS_CI} = true ]; then
	GRADLE_ARGS=" --console=plain";
fi

SETTINGS_FILE_ARGS="";
if [ -f ${CUSTOM_SETTINGS_GRADLE_FILE} ]; then
	SETTINGS_FILE_ARGS=" -c $CUSTOM_SETTINGS_GRADLE_FILE"; #--settings-file
fi

echo ">> Setup-ing keys...";
./keys_setup.sh;
RESULT=$?;
checkResult ${RESULT};
echo ">> Setup-ing keys... DONE";

echo ">> Gradle cleaning...";
../gradlew ${SETTINGS_FILE_ARGS} clean ${GRADLE_ARGS};
RESULT=$?;
checkResult ${RESULT};
echo ">> Gradle cleaning... DONE";

if [ ${IS_CI} = true ]; then
    echo ">> Running lint & test...";
	../gradlew ${SETTINGS_FILE_ARGS} lint test ${GRADLE_ARGS};
	RESULT=$?;
	checkResult ${RESULT};
    echo ">> Running lint & test... DONE";

    echo ">> Running build & assemble...";
	../gradlew ${SETTINGS_FILE_ARGS} build assemble ${GRADLE_ARGS};
	RESULT=$?;
	checkResult ${RESULT};
	echo ">> Running build & assemble... DONE";
fi

echo ">> Running assemble release & copy-to-output dir...";
../gradlew ${SETTINGS_FILE_ARGS} :${DIRECTORY}:assembleRelease :${DIRECTORY}:copyReleaseApkToOutputDirs ${GRADLE_ARGS};
RESULT=$?;
checkResult ${RESULT};
echo ">> Running assemble release & copy-to-output dir... DONE";

echo ">> Cleaning keys...";
./keys_cleanup.sh;
RESULT=$?;
checkResult ${RESULT};
echo ">> Cleaning keys... DONE";

echo ">> Building... DONE";
exit ${RESULT};
