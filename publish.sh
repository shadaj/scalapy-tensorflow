#!/bin/bash

set -e # exit with nonzero exit code if anything fails

openssl aes-256-cbc -K $encrypted_54601e0c0227_key -iv $encrypted_54601e0c0227_iv -in secrets.tar.enc -out secrets.tar -d

tar xvf secrets.tar

sbt publishSigned sonatypeRelease
