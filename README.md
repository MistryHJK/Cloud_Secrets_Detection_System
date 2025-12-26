# Cloud_Secrets_Detection_System
A cloud-based DevSecOps tool to detect exposed secrets in source code repositories and store security scan reports securely using AWS and GCP.

# Cloud-Based Secrets Detection & Security Scanning System

## Overview
Accidental exposure of sensitive credentials such as API keys, database passwords, and access tokens in source code repositories is a common security issue in the IT industry. Such leaks can lead to data breaches, financial loss, and unauthorized access to cloud resources.

This project is a **cloud-based DevSecOps security tool** that scans code repositories to detect exposed secrets, assigns risk levels, and stores security reports securely in the cloud. The system is designed to help developers and organizations identify security issues early in the development lifecycle.

---

## Problem Statement
In real-world software development:
- Developers may unintentionally commit secrets to repositories.
- Manual code reviews often miss exposed credentials.
- Small teams lack automated security tools.
- Security checks are often added too late in the pipeline.

As a beginner, this project focuses on solving a **real and practical security problem** using simple, explainable techniques.

---

## Solution
This project provides:
- Automated scanning of source code files
- Detection of common secrets using pattern matching
- Risk classification (Low / Medium / High)
- Secure storage of scan results
- Cloud-hosted API for triggering scans and retrieving reports

The solution follows **DevSecOps principles** by integrating security checks early and automating detection.

---

## Key Features
- Scan repositories or uploaded source code files
- Detect exposed secrets such as:
  - API keys
  - Access tokens
  - Passwords
- Assign severity levels to findings
- Store scan reports securely in AWS S3
- REST API for scan management
- Cloud deployment using Google Cloud Run

---

## High-Level Architecture

User
↓
Node.js REST API (GCP Cloud Run)
↓
Java Security Scanner Engine
↓
Scan Results (JSON)
↓
AWS S3 (Secure Storage)


---

## Technology Stack

### Backend & Logic
- **Java** – Security scanning engine
- **Node.js (Express)** – REST API layer

### Cloud Services
- **AWS**
  - S3 – Store security scan reports
  - IAM – Secure access control
- **GCP**
  - Cloud Run – Containerized deployment for Node.js service

### Other Tools
- Docker (basic containerization)
- Git & GitHub
- Markdown for documentation

---

## Why Multi-Cloud?
This project intentionally uses both AWS and GCP to:
- Understand cloud services conceptually, not vendor-specific tools
- Avoid vendor lock-in
- Learn real-world multi-cloud design patterns at a beginner level

AWS is used for **secure storage**, while GCP is used for **serverless application deployment**.

---

## Scope & Limitations
**Included:**
- Basic regex-based secret detection
- Simple risk scoring
- Cloud storage of reports

**Not Included (Future Enhancements):**
- Advanced entropy-based detection
- Real-time CI/CD integration
- Enterprise IAM policy scanning
- Machine learning-based detection

---

## Learning Outcomes
Through this project, I learned:
- How security issues arise in real-world software systems
- Basics of DevSecOps and security automation
- How to build and deploy cloud-based applications
- How to document and design systems before implementation
- How to integrate Java and Node.js services

---

## Target Roles
- Software Engineering Intern
- DevOps Intern
- Security Engineering Intern
- Junior Software Engineer / Fresher

---

## Project Status
🟡 Documentation completed  
🟡 Development in progress  

---

## Author
Henil Mistry 
Aspiring Software Engineer | Security & DevOps Enthusiast
