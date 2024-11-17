# Website Status Checker

**Website Status Checker** is a Java-based practice project designed to help me learn and apply key programming concepts such as **Object-Oriented Programming (OOP)**, **file management**, and **API calls**. The program checks the availability and status of websites, either individually or by reading a list of websites from a text file.

## Table of Contents
- [Description](#description)
- [Goals](#goals)
- [Key Features](#key-features)
- [Technologies Used](#technologies-used)
- [How to Use](#how-to-use)
- [Learning Outcomes](#learning-outcomes)
- [License](#license)

## Description

The **Website Status Checker** allows you to:
- Check the status of a **single website** by entering its URL.
- Check the status of **multiple websites** by providing a text file containing a list of URLs.
- Receive the HTTP status code for each website (e.g., `200 OK`, `403 Forbidden`, `404 Not Found`, `500 Server Error`).
- The project demonstrates how to send **asynchronous HTTP requests** using Java's `HttpClient` and **manage files** with Java I/O APIs.

This project is built to practice the following:
- **Object-Oriented Programming (OOP)** principles.
- **File management** and reading/writing to files.
- **API calls** to check website status using HTTP.

## Goals

The primary goals of this project are:
1. **Learn and apply Object-Oriented Programming (OOP)**:
   - Break down the problem into modular, reusable classes.
   - Practice class design, method decomposition, and encapsulation.
   
2. **Learn file management** in Java:
   - Read data in text files.
   - Handle file-related exceptions and automate file creation if necessary.
   
3. **Learn to make API calls**:
   - Send HTTP requests asynchronously to websites.
   - Process HTTP responses and handle status codes (e.g., `200`, `404`, etc.).

## Key Features

- **Single Website Check**: 
   - Input a website URL to check if the site is reachable and get its status code.
   
- **Multiple Website Check**: 
   - Provide a `websites.txt` file with a list of URLs. The program will read the file and check each website’s status.

- **Asynchronous HTTP Requests**: 
   - Uses **`CompletableFuture`** to send non-blocking HTTP requests, allowing for faster, concurrent checks of multiple websites.

- **File Management**:
   - Reads websites from a text file (`websites.txt`). If the file doesn't exist, it creates one.
   - Handles reading, writing, and managing the file with Java’s **I/O APIs**.

- **User-friendly Console Interface**:
   - Simple menu-driven interface to interact with the program.
   - Provides feedback for each website checked, showing whether it is working or has issues.

## Technologies Used

- **Java 17** (or later) for the core implementation.
- **`HttpClient`** for making HTTP requests.
- **`CompletableFuture`** for handling asynchronous operations.
- **Java I/O** (`BufferedReader`, `Path`, `Files`) for file handling.
- **JVM-based concurrency** for asynchronous checks.

## License
This project is for educational purposes and is licensed under the MIT License.
