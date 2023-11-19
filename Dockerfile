# Select base image
FROM maven:3.9.5-eclipse-temurin-11 as setup

# Setup some directories
RUN mkdir -p /home/app \
    && mkdir -p /home/programs/chrome \
    && mkdir -p /home/programs/chromedriver

#Download Maven dependencies (and go ahead and copy the source code)
RUN echo "Downloading Maven dependencies..." \
    && mkdir -p /home/app
WORKDIR /home/app
COPY pom.xml .
COPY src ./src
RUN mvn dependency:resolve
WORKDIR /home

# Install Sudo
RUN su - \
    && apt update \
    && apt install sudo -y \
    && exit

#Install Zip/Unzip
RUN  sudo apt install -y zip

# Install Chrome
WORKDIR /home/programs/chrome
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN sudo apt install -y /home/programs/chrome/google-chrome-stable_current_amd64.deb

# Install Chromedriver
WORKDIR /home/programs/chromedriver
RUN mkdir -p app/bin
RUN wget https://chromedriver.storage.googleapis.com/114.0.5735.90/chromedriver_linux64.zip
RUN unzip chromedriver_linux64.zip -d app/bin/
RUN chmod +x app/bin/chromedriver

# Execute tests
FROM setup as test
WORKDIR /home/app
RUN echo "Starting tests..."
CMD ["mvn", "-X", "clean", "test"]

