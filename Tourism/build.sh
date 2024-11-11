#!/usr/bin/env bash

sudo docker build --file Dockerfile.build -o classes .
sudo chown -R "$USER":"$USER" classes
