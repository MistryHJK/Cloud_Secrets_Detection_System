# Architecture Design – Cloud Secrets Detection System

## Purpose of This Document
This document explains the **system architecture**, **component responsibilities**, and **data flow** of the Cloud-Based Secrets Detection & Security Scanning System.

It is intended to:
- Clearly describe how the system works
- Help understand design decisions
- Support technical discussions during interviews

---

## High-Level Architecture Overview

User
->
Node.js REST API (GCP Cloud Run)
->
Java Security Scanner Engine
->
Scan Results (JSON)
->
AWS S3 (Secure Storage)


---

## Component Breakdown

### 1. User
The user interacts with the system by:
- Uploading source code files or repositories
- Triggering a security scan
- Viewing scan results through API responses

The user does **not** interact directly with cloud services.

---

### 2. Node.js REST API (GCP Cloud Run)

**Responsibilities:**
- Acts as the main entry point to the system
- Accepts scan requests from users
- Validates input files or repository data
- Triggers the Java security scanner
- Returns scan status and results

**Why Node.js?**
- Lightweight and fast for REST APIs
- Easy integration with cloud services
- Widely used in real-world backend systems

**Why GCP Cloud Run?**
- Serverless container deployment
- Automatic scaling
- No infrastructure management required
- Beginner-friendly cloud service

---

### 3. Java Security Scanner Engine

**Responsibilities:**
- Scans source code files line by line
- Detects exposed secrets using regex-based pattern matching
- Identifies common secrets such as:
  - API keys
  - Access tokens
  - Passwords
- Assigns severity levels (Low / Medium / High)
- Generates scan results in JSON format

**Why Java?**
- Strong file handling capabilities
- Good performance for scanning large files
- Commonly used in enterprise security tools

---

### 4. Scan Results (JSON)

The scanner produces structured output in JSON format, including:
- File name
- Line number
- Detected secret type
- Risk level
- Timestamp

This format allows:
- Easy storage
- Easy API responses
- Future analytics or dashboard integration

---

### 5. AWS S3 (Secure Storage)

**Responsibilities:**
- Stores scan reports securely
- Maintains scan history
- Acts as persistent storage

**Why AWS S3?**
- Highly durable and reliable
- Secure access using IAM roles
- Industry-standard object storage service

---

## Data Flow Explanation (Step-by-Step)

1. User sends a request to start a scan
2. Node.js API receives and validates the request
3. API invokes the Java scanner engine
4. Java engine scans files and detects secrets
5. Scan results are generated as JSON
6. Results are uploaded to AWS S3
7. API returns a response to the user

---

## Security Considerations (Beginner-Level)

- No secrets are hardcoded in the source code
- Cloud access is controlled using IAM roles
- Scan results are stored securely in cloud storage
- Only authorized services can upload or retrieve reports

---

## Design Decisions & Justifications

### Why Multi-Cloud?
- Learn cloud services conceptually
- Avoid vendor lock-in
- Simulate real-world architectures
- Separate compute (GCP) and storage (AWS)

### Why Documentation-First?
- Reduce confusion during development
- Improve clarity of design
- Make interview explanations easier
- Follow real-world engineering practices

---

## Limitations of Current Architecture

- No real-time CI/CD integration
- Regex-based detection only
- No advanced anomaly detection
- No authentication system (future improvement)

---

## Future Architecture Enhancements

- CI/CD pipeline integration (DevSecOps)
- Authentication & authorization
- Dashboard for visualizing scan results
- Advanced secret detection techniques
- Cloud-native logging and monitoring

---

## Summary
This architecture is intentionally **simple, clear, and scalable**.  
It focuses on **learning, explainability, and real-world relevance**, making it suitable for intern and fresher-level roles while leaving room for future expansion.
