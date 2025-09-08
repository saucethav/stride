# Stride – Time Management App 

**Stride** is a full‑stack time management and project planning application.  
It helps individuals and small teams **organize, prioritize, and schedule tasks efficiently** – 
bridging the gap between "I have a to‑do list" and "When exactly should I do this?"

---

## Tech Stack
- **Backend**: Java 24, Spring Boot 3.5
- **Database**: MySQL 8
- **Frontend (coming soon)**: Angular + Angular Material / TailwindCSS
- **APIs**: REST (JSON)

---

## Current Features
- User entity with CRUD REST APIs
- Project entity with CRUD REST APIs (linked to users)
- Input validation (`@NotBlank`, `@Email`)
- Global exception handling (validation & DB errors)
- MySQL integration (`stride_db`)

---

## Getting Started
1. Clone the repo  
   ```bash
   git clone https://github.com/YOUR_USERNAME/stride-time-management.git
   cd stride-time-management
