# ⚡ WAPDA Management System – Java GUI & MySQL

This WAPDA Management System is a desktop application built with Java Swing and MySQL to manage electricity billing, user information, and utility access. It features a clean graphical interface and allows authenticated users to update/view information, generate reports, and access built-in utilities like Notepad, Calculator, and Chrome Browser.


## 👥 Roles & 🚀 Features

### 🔐 Authentication
- **Login Page** – Secure login for Admins and Customers
- **Signup Page** – Customer registration into the system

---

### 👤 User (Customer) Role

#### 📋 Navigation Options:
- **Information**
  - `Update Info` – Modify personal information
  - `View Info` – View personal data and meter information
- **User**
  - `Electricity Bill` – Submit or review electricity usage
  - `Bill Details` – View previously paid or pending bills
- **Report**
  - `Generate Bill` – Search and view billing history by month
- **Utilities**
  - `Notepad` – Launches system Notepad
  - `Calculator` – Opens system Calculator
  - `Chrome Browser` – Opens Google Chrome
- **Logout** – Ends session and returns to login screen

---

### 👨‍💼 Admin Role

#### 🔧 Admin Features:
- **Add New Customer** – Register a new customer and create meter entry
- **Delete Customer** – Remove customer record from the system
- **Calculate Bill** – Input number of units to auto-calculate bill
- **View Meter Info** – Access detailed customer and meter data
- **Deposit/Print Bill** – Finalize payment or print bill information for records

---

## 🛠️ Technologies Used

- **Java (Swing)** – GUI development
- **MySQL** – Backend database
- **JDBC** – Java Database Connectivity
- **IDE** – Developed using VS-Code

---

## 📸 Screenshots

- ![Login Page]()
- ![Home Page]()
- ![SignUp Page]()
- ![ViewInfo Page]() 
- ![UpdateInfo Page]()
- ![Electricity Bill Page]()
- ![Generate Bill Page]()
- ![Add NewCustomer Page]() 
- ![DeleteCustomer Page]()
- ![Calculate Bll Page]()
- ![MeterInfo Page]()


---

## 🧩 Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/wapda-management-system.git
   

2. **Import Database**  
  Import the provided .sql file into your MySQL server.
  

3. **Update DB Config**  
  In the Java code, configure your DB connection:

  String url = "jdbc:mysql://localhost:3306/your_db_name";
  String username = "root";
  String password = "your_password";

5. **Run the Project**
  Open the project in VS-Code or Eclipse
  Run the main class


---

✅ Future Improvements
Role-based dashboards with UI distinction

PDF export of bills

Email notifications for due payments

Enhanced UI styling (themes/dark mode)


---

📄 License
This project is open-source and free to use for educational purposes.


---

🙌 Acknowledgment
Developed by [Zubair Ahmed]
Feel free to contribute or fork the repository!

