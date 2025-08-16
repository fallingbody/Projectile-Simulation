# 🚀 Projectile Motion Simulator (Java)

A simple **Java-based console project** that simulates projectile motion and visualizes the trajectory using ASCII art.  
It calculates **time of flight, maximum height, and horizontal range** for a given initial velocity and launch angle.

---

## 📌 Features
- Takes **initial velocity (m/s)** and **launch angle (degrees)** as input  
- Calculates:
  - ⏱️ Time of Flight  
  - 📈 Maximum Height  
  - 📏 Horizontal Range  
- Prints an **ASCII-art trajectory** showing the curved motion  
- Cross-platform: runs on any system with **Java 8+**

---

## 🛠️ How It Works
1. User enters velocity `v` and angle `θ`.  
2. Program converts `θ` into radians.  
3. Formulas used:
   - Time of Flight: `T = 2v·sinθ / g`  
   - Maximum Height: `H = (v²·sin²θ) / (2g)`  
   - Range: `R = (v²·sin(2θ)) / g`  
4. Prints values and generates a **trajectory graph** with `*` for path and `_` for ground.  

---

## ▶️ Run the Program
```bash
# Compile
javac ProjectileSimulation.java

# Run
java ProjectileSimulation
