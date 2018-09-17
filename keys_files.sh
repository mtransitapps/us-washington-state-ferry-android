#!/bin/bash
declare -a FILES=(
	"key-store-release.keystore"
	"keys.properties"
	"res/values/keys.xml"
);
echo "Files:";
printf '* "%s"\n' "${FILES[@]}";
