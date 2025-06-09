# Support-Desk

 # 🖥️ Support Desk - IT Support Ticketing System

**Support Desk** is a web-based application built to serve the IT support needs of an organization. It allows employees to raise technical issues through tickets, and enables the IT support team to manage and resolve those requests efficiently from a centralized dashboard.

## 🔍 Overview

- Employees can create support tickets for IT-related issues.
- Tickets are tracked and managed by the IT support team in a dedicated dashboard.
- Real-time updates on ticket status help both employees and IT staff stay informed.
- Improves internal communication and streamlines the support process.
- Designed for use in corporate IT environments to increase efficiency and responsiveness.

## 🚀 Features

- User-friendly ticket submission form for employees.
- IT Support Dashboard to manage, update, and resolve tickets.
- Role-based access for employees and IT team members.
- Ticket status tracking (Open, In Progress, Resolved, Closed).
- Email or notification system (optional, if implemented).
- Admin-level controls for managing users and system settings.

## 🛠️ Tech Stack

- **Frontend:** React.js
- **Backend:** Java Spring Boot
- **Database:** MySQL 
- **Other Tools:** REST APIs, Git, IntelliJ, VS Code




## 🔐 Authentication

This project uses **JWT (JSON Web Token)** to secure authentication and authorization:
- Users must log in to receive a JWT.
- JWT is included in API requests to access protected routes.
- Roles (e.g., `employee`, `IT-Support`) are enforced using token payloads.
  
![Screenshot 2025-06-05 141738](https://github.com/user-attachments/assets/a7968e7f-5558-46e2-8ad0-f41ff579c7db)

### 📝 Employee Request Page

Employees raise a ticket and assign priority:



![Screenshot 2025-06-05 142117](https://github.com/user-attachments/assets/23dde109-9d56-4613-85b0-a6117fa61539)


This is an **IT-Support Dashboard**. It is used to:

- Resolve support tickets
- Send email notifications to users about ticket status

- ## 🤖 AI-Powered Email Generation

This project uses **ChatGPT 4o-mini** to **generate dynamic and professional email content** for ticket responses.

- AI model: `gpt-4o-mini`
- Integration: OpenAI API
- Usage: Automatically generates ticket resolution emails based on user input and issue description

### 🔐 API Key Setup

To enable AI-based email generation, you must set your OpenAI API key in your environment:

![what-is-ai-1](https://github.com/user-attachments/assets/6b68d1a8-8f3d-498d-a106-7711166bc9e5)






![Screenshot 2025-06-05 142335](https://github.com/user-attachments/assets/bcdfd749-96f6-4404-a2af-85333d88025d)


## 📊 Analytics Page

The **Analytics** page provides a **visual chart representation** of all ticket statuses, helping IT teams understand performance at a glance.

It displays the number of:

- ✅ Resolved Requests
- ❌ Rejected Requests
- ⏳ Pending Requests

![Screenshot 2025-06-05 142153](https://github.com/user-attachments/assets/43334bb9-04d0-4e3d-a746-3d7d11cb5885)

## 👥 Employee & IT Support Team Page

This page displays detailed information about employees and the IT support team.

- View employee details and IT support team members
- Click on an employee to see the number of issues reported by them
- Detailed issue list for each selected employee to track their raised tickets


![Screenshot 2025-06-05 142419](https://github.com/user-attachments/assets/31ae2c9f-aa0c-43f8-a9bd-ee3669bc4833)


## 🌐 Technology Stack & Key Features

This website is built with a **React.js frontend** and a **Java Spring Boot backend**, providing a robust and scalable full-stack solution. The application leverages **JWT (JSON Web Tokens)** for authentication and secure access control, ensuring that only authorized users can interact with the system. The primary goal of this platform is to significantly **reduce the workload and response time of the IT-support team** by streamlining the ticket management process and automating routine tasks.

## 📊 Analytics Dashboard & User Interface

The analytics page is designed to offer a comprehensive and user-friendly overview of the IT-support operations. It presents key performance metrics such as the number of resolved, pending, and rejected tickets through **interactive charts and detailed tables**, which are implemented using popular and efficient React libraries. This visual data representation enables the support team and management to quickly assess the current status of support requests and make data-driven decisions.

## 🤖 AI-Driven Email Content Generation & Communication

To enhance communication efficiency, the system integrates with the **ChatGPT model `gpt-4o-mini`** to automatically generate clear, professional, and context-aware email content. This AI-powered feature assists the IT-support team by drafting customized email messages that update employees on the status of their reported issues. Furthermore, the application utilizes Java’s mail API to **send these emails directly to employees**, ensuring timely notifications and clarifications regarding their support tickets, thereby improving transparency and user satisfaction.

