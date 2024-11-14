#!/usr/bin/env bash

set -e

sudo docker build --file Dockerfile.build -o . .
sudo chown -R "$USER":"$USER" classes
sudo chown -R "$USER":"$USER" spotbugs.html
