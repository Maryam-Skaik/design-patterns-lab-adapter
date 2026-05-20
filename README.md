# 🧩 Adapter Design Pattern (Java)

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![Pattern](https://img.shields.io/badge/Design%20Pattern-Structural-green.svg)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Intermediate-orange.svg)
![Focus](https://img.shields.io/badge/Focus-Integration%20%26%20Compatibility-purple.svg)

---

## 🎥 Lecture Video

This repository accompanies the lecture on the **Adapter Pattern**, focusing on integrating incompatible systems and building flexible backend architectures.

▶️ Watch on YouTube:

[Lecture Video](https://youtu.be/s8naiV7BOqc)

---

## 🧠 Overview

The **Adapter Pattern** is a structural design pattern that allows incompatible interfaces to work together.

It acts as a translator between:

* the structure expected by the application
  and
* an external or incompatible system

Instead of rewriting existing systems, the adapter converts one interface into another compatible interface.

This pattern is extremely common in:

* backend engineering
* API integrations
* payment gateways
* external SDK integrations
* legacy system migration

---

## 💡 Core Idea

> Convert one interface into another interface the client expects.

Or more simply:

> Make incompatible systems communicate safely.

---

## 🏗️ Real-World Analogy

Imagine a company receiving invoice files from different suppliers.

Each supplier sends files in different formats:

* Excel
* XML
* CSV
* JSON

But the accounting system only understands one standard structure.

Instead of rewriting the accounting system every time:

1. supplier sends external format
2. converter transforms the structure
3. accounting system receives compatible data

The converter behaves exactly like:

> the Adapter Pattern.

---

## ⚙️ When to Use This Pattern

Use Adapter Pattern when:

* integrating third-party APIs
* consuming external SDKs
* working with legacy systems
* unifying different providers
* standardizing communication structures
* migrating systems gradually
* avoiding modification of external code

---

## ❌ Problem Without This Pattern

Without Adapter Pattern, systems directly depend on external implementations.

Example:

```java id="z3d9xa"
legacyBankAPI.makeTransaction(amount);
```

Problems with this approach:

* Tight coupling
* Harder maintenance
* Difficult provider replacement
* Scattered conversion logic
* Fragile architecture
* Reduced scalability

As systems grow, direct integrations become increasingly difficult to manage.

---

## 🧩 Solution Approach

The Adapter Pattern separates responsibilities into four main components.

---

### 🔵 Target Interface

* Defines the structure expected by the backend
* Standardizes communication
* Creates abstraction between backend and providers

Example:

* PaymentProcessor

---

### 🟢 Adaptee

* Represents the incompatible external system
* Existing SDK or third-party service
* Cannot directly communicate with backend structure

Example:

* LegacyBankAPI

---

### 🟣 Adapter

* Converts interfaces
* Wraps external systems internally
* Translates calls between structures

Example:

* BankAdapter

---

### 🟡 Client

* Uses only the standard interface
* Remains independent from provider details
* Depends on abstraction instead of implementation

Example:

* Main class / backend service

---

## 📊 UML Structure

```text
              <<interface>>
            PaymentProcessor
            ----------------
            + pay(amount)

                    ▲
                    │
             BankAdapter
            ----------------
            - LegacyBankAPI
            + pay(amount)

                    │
                    ▼
              LegacyBankAPI
            ----------------
            + makeTransaction()

                    ▲
                    │
                  Main
                 (Client)
```

---

## 🧪 Example Scenario — E-Commerce Backend

Imagine an E-Commerce backend system.

The backend expects all payment providers to expose:

```java id="x9d1fr"
pay(double amount)
```

However, an old banking SDK already exists and exposes:

```java id="e5v2mw"
makeTransaction(double value)
```

#### Requirement

The backend should:

* use one standard payment interface
* remain independent from provider implementation
* support future payment providers easily
* avoid modifying external SDKs

Important condition:

> the backend should NOT directly depend on external provider structures.

---

## 🔥 Core Behavior Explained

When the system runs:

* The backend communicates only with the standard interface
* The adapter wraps the external SDK
* The adapter translates requests internally
* The backend simply calls:

```java id="b4x0kp"
paymentProcessor.pay(250);
```

Inside the adapter:

```java id="p2f8ma"
pay() → makeTransaction()
```

This creates:

* loose coupling
* scalability
* maintainability
* provider flexibility

---

## 🧠 Key Insight

A very important mental model:

* **Client = uses abstraction**
* **Adapter = translates requests**
* **Adaptee = external incompatible system**

Or:

> The backend decides *what it wants*
> The adapter decides *how to translate it*

---

## 🔄 Runtime Flexibility Example

The same backend can support completely different payment providers simply by changing adapters.

Example flow:

```text
1. Create PayPalAdapter
2. Create StripeAdapter
3. Create BankAdapter
4. Backend uses PaymentProcessor only
```

No modification is required inside backend business logic.

---

## 🌍 Real-World Applications

The Adapter Pattern is widely used in real backend systems.

Examples include:

* payment gateways
* REST API integrations
* cloud storage systems
* SMS providers
* email services
* database drivers
* authentication providers
* legacy ERP systems
* Kafka/RabbitMQ wrappers

---

## 🧠 Design Principles Behind It

This pattern strongly supports:

### ✅ Favor Composition Over Inheritance

The adapter wraps external systems instead of inheriting from them.

---

### ✅ Open/Closed Principle

New adapters can be added without modifying backend logic.

---

### ✅ Single Responsibility Principle

Each adapter handles one compatibility translation responsibility.

---

## 🚀 Advantages of Adapter Pattern

| Advantage       | Explanation                      |
| --------------- | -------------------------------- |
| Reusability     | Reuse external services safely   |
| Flexibility     | Integrate multiple providers     |
| Maintainability | Cleaner architecture             |
| Scalability     | Easy provider expansion          |
| Decoupling      | Backend depends on abstraction   |
| Isolation       | External changes remain isolated |

---

## ⚠️ Disadvantages of Adapter Pattern

| Disadvantage                 | Explanation                   |
| ---------------------------- | ----------------------------- |
| More Classes                 | Adds adapter layers           |
| Extra Abstraction            | Slightly increases complexity |
| Additional Translation Logic | Requires conversion handling  |

---

# 🎯 Learning Outcome

After studying this pattern, you should be able to:

* Identify incompatible system integrations
* Design adapter-based architectures
* Reduce coupling between services
* Integrate external SDKs safely
* Build scalable backend integrations
* Apply composition correctly
* Standardize communication between providers

---

# 🚀 Final Insight

The Adapter Pattern becomes powerful when:

> external systems can change freely while the backend remains stable through standardized abstractions.
