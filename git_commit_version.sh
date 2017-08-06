#!/bin/bash
source ../commons/commons.sh
echo ">> GIT comnmiting version...";
VERSION_PROPERTIES="version.properties";
if [ -f $VERSION_PROPERTIES ]; then
	readarray -t LINES < $VERSION_PROPERTIES;
	LINE=${LINES[1]};
	VERSION=$(echo $LINE | cut -d'=' -f 2);
	MESSAGE="Version $VERSION";
	echo "Message: $MESSAGE";
	git commit -m "$MESSAGE";
else
	echo "File $VERSION_PROPERTIES doesn't exist!";
	exit;
fi
echo ">> GIT comnmiting version... DONE";
