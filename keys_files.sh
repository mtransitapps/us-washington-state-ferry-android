#!/bin/bash
declare -a FILES=("res/values/keys.xml" "keys.properties" "key-store-release.keystore");
echo "Files:";
printf '* "%s"\n' "${FILES[@]}";
