# **Java Chat Application**

## **Overview**
This project implements a real-time **multithreaded chat application** using **Java** and **TCP protocol**. The application is designed to enable multiple clients to communicate with each other via a server. It uses a custom protocol to ensure reliable and structured message exchange and provides a basic GUI interface for users.

---

## **Features**
- **Real-time Communication:** Supports simultaneous messaging between multiple clients.
- **Custom Protocol:** Built on TCP for reliable and error-free data transmission.
- **Multithreading:** Efficiently handles multiple client connections.
- **GUI Interface:** Features an intuitive user interface for typing and reading messages.
- **Scalability:** The application can accommodate multiple users without performance issues.

---

## **Technologies Used**
- **Programming Language:** Java
- **Protocol:** TCP
- **Frameworks/Tools:** Java Swing for GUI, multithreading for handling concurrent connections.

---

## **Project Structure**
- **`build/`:** Compiled files for the application.
- **`nbproject/`:** Configuration files for the NetBeans IDE.
- **`src/`:** Source code for the application, including client, server, and utility classes.
- **`test/`:** Unit test files for verifying the application's functionality.
- **`manifest.mf`:** Configuration file for packaging the application.

---

## **How It Works**
1. **Server:**
   - Listens for client connections on a specified port.
   - Relays messages from one client to all other connected clients.

2. **Client:**
   - Connects to the server using a unique username.
   - Sends and receives messages in real-time through the GUI.

3. **GUI:**
   - Text fields for typing messages.
   - Text area for displaying the chat history.
   - Buttons for sending messages and closing the application.

---

## **Getting Started**
### **Prerequisites**
- Java Development Kit (JDK) 8 or later.
- An IDE such as NetBeans, Eclipse, or IntelliJ IDEA.

### **Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Java-Chat-Application.git
   cd Java-Chat-Application
