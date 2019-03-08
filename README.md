# Chat Message Language Translation API
A custom API which accepts a message and one of three support languages (English, Chinese and Spanish) and outputs a JSON with the message translated into the three supported languages.

It also includes an email service to allow sharing chat invitations via email.

This was created for the chat application Babel Chat as part of a submission to the [2019 Hack the South Hackathon](https://hackthesouth.co.uk/). The devpost project is [here](https://devpost.com/software/babel-chat).

## Getting Started

You can get started by cloning the project to your local machine:
```
$ git clone https://github.com/amitchell94/hackathon-language-api.git
```

You will need to sign up to the [Google Translate API](https://cloud.google.com/translate/) and obtain an API key.
You will then need to change the value of API_KEY to your API key in the [GoogleApiRepository.java file](/src/main/java/com/babelapp/babelapp/data/GoogleApiRepository.java)

### Prerequisites

In order to execute this program you will need to install the following:
* Java JDK
* Gradle

## Usage

### Message Translation
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
### Email Chat Invitations
The API includes an email service which sends a invitation to the chat. By sending a HTTP post request to the /sendemail/ with the email address and chat code formatted into a JSON, the email service will send an invitation to the chat to the desired email address.

Example URL:
```
http://localhost:8080/sendemail/
```
Example Http Body:
```
{
    "email":"example@example.com",
    "chatcode":"ABCDEF"
}
```

If the email is sent successfully the response will be the text "Email sent successfully", otherwise the response will be "Failed to send email".

## Built With

* [Gradle](https://gradle.org/) - Dependency Management

## Authors

* **Andy Mitchell** - *Initial work* - [GitHub](https://github.com/amitchell94)

