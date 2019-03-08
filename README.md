# Chat Message Language Translation API
A custom API which accepts a message and one of three support languages (English, Chinese and Spanish) and outputs a JSON with the message translated into the three supported languages.

## Getting Started

You can get started by cloning the project to your local machine:
```
$ git clone https://github.com/amitchell94/hackathon-language-api.git
```

You will need to sign up to the [Google Translate API] (https://cloud.google.com/translate/) and obtain an API key.
You will then need to change the value of API_KEY to your API key in the [GoogleApiRepository.java file](/src/main/java/com/babelapp/babelapp/data/GoogleApiRepository.java)

## Usage

The API accepts a HTTP Post request to the /translate/ endpoint. This request should contain the source language of the message (en for English, zh for Chinese,es for Spanish) as a query parameter and the message to be converted as the body.

Example URL:
```
http://localhost:8080/translate/?sourcelanguage=en
```
Example Http Body:
```
Hello, this is a message.
```

The response should be in the form of a JSON with the message translated into the three supported languages.
```
{
    "en":"Hello, this is a message",
    "zh":"您好，这是一条消息",
    "es":"Hola este es un mensaje"
}
```

### Prerequisites

In order to execute this program you will need to install the following:
* Java JDK
* Google Translate API
* Gradle
