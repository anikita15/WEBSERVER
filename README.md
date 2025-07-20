# WEBSERVER
Java Threading Project

# Java Web Server Project

This project contains two implementations of a simple web server in Java:

- ✅ **Single-Threaded Web Server**  
- 🔁 **Multi-Threaded Web Server**

These servers can accept HTTP requests and respond with static content (HTML, CSS, etc.). The multi-threaded version is optimized to handle multiple client requests simultaneously using Java threads.

---

## 📁 Project Structure

WebServerProject/
│
├── SingleThreaded/
│ ├── Client.java
│ └── Server.java
│
├── MultiThreaded/
│ ├── ClientHandler.java
│ └── Server.java
│
└── README.md

---

## 🚀 Features

### 🧵 Single-Threaded Server
- Processes one client request at a time
- Simple and easy to understand
- Good for learning basic socket programming

### 🔄 Multi-Threaded Server
- Handles multiple clients concurrently using threads
- Demonstrates the use of `Runnable` and `Thread`
- Better performance under multiple connections

---

## 🔧 Requirements

- Java 8 or higher
- Terminal/Command Prompt

---

## ▶️ How to Run

### 1. Compile the server files

#### For SingleThreaded:
```bash
cd SingleThreaded
javac Server.java Client.java
