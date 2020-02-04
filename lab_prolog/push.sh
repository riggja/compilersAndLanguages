#!/bin/sh
  
git add --all
if [ $# -eq 0 ];
then
    git commit -m "auto-commit"
else
    git commit -m "$*"
fi
git push
