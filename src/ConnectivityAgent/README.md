# The "Connectivity Agent"

## 📝 The Business Scenario
The Site Reliability Engineering (SRE) team needs a reliable way to verify if their servers are actually online. They don't want to trust the dashboard; they want a "heartbeat" check performed from the agent itself.

**The Requirement:**
The system must be able to ping a specific IP address exactly **once**.
* If the machine responds (Exit Code 0), the system reports it as **Online**.
* If the machine is unreachable, times out, or the command fails (Exit Code != 0), the system reports it as **Offline**.

---

## 🚀 Your Mission

### 1. The Contract (Interface)
Design the interface yourself.
* **Goal:** It should be a generic contract for any connectivity check (Ping, Telnet, HTTP, etc.).
* **Method:** It needs to accept a target (like an IP) and return a simple boolean status.

### 2. The Implementation (Bean)
Create the class `RealPingTester` that implements your interface.
* **Tech Stack:** Use `java.lang.ProcessBuilder`.
* **Command:** `ping -c 1 <ip_address>` (This works on Mac/Linux).
* **Logic:**
    * Configure the process.
    * Run it.
    * Wait for it to finish.
    * **Crucial:** Return `true` *only* if the OS exit code is 0.
    * **Safety:** If the process crashes or throws an exception, catch it and return `false`.

### 3. The Proof (Main)
Write a `Main` class to test it.
* **Test 1:** Ping `8.8.8.8` (Google DNS) -> Should print "Online: true"
* **Test 2:** Ping `192.0.2.0` (Test-NET, usually unreachable) -> Should print "Online: false"

---

## ⚠️ Constraints
* **No Stream Reading:** For this specific task, you do **not** need to read the text output (stdout). The **Exit Code** is the only thing that matters.
* **Blocking:** It is acceptable for `waitFor()` to block the thread until the ping finishes.