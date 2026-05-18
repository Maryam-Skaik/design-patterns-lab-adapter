# 🧪 Activity: Multi Payment Gateway Integration System (Adapter Pattern)

## 🎯 Objective

Design a backend payment system using the **Adapter Pattern** to integrate multiple external payment providers with different interfaces into a single unified system.

---

## 📌 Scenario

You are building an **E-Commerce Checkout System**.

The system must support multiple payment providers:

* 💳 Stripe
* 🏦 Local Bank API
* ₿ Crypto Payment Service

Each provider:

* exposes different method names
* uses different request structures
* has incompatible interfaces

However, the checkout system expects a unified interface:

> `PaymentProcessor`

---

## ⚠️ Problem Context

Without a proper design:

* Each payment provider will be called differently
* The checkout system will become tightly coupled to external APIs
* Conditional logic will grow inside the checkout service
* Adding a new provider will require modifying existing code
* Integration becomes fragile and hard to maintain

Example bad design patterns:

```java id="x1k9pl"
if (type.equals("stripe")) { ... }
if (type.equals("bank")) { ... }
if (type.equals("crypto")) { ... }
```

This leads to:

* low scalability
* high coupling
* poor maintainability

---

## 🧠 Your Task

Design a **Multi Payment Gateway System** using the **Adapter Pattern**.

You must:

* unify all payment providers under one interface
* create adapters for each external system
* keep checkout system independent from providers
* ensure easy addition of new payment gateways

---

## 📏 Requirements

---

### 🔵 Target Interface

Create a standard interface:

* `PaymentProcessor`
* contains method: `pay(double amount)`

This represents the expected contract used by the checkout system.

---

### 🟢 Adaptee Systems (External Providers)

You are given three incompatible systems:

#### 💳 StripeService

* uses: `processPayment(double amount)`

---

#### 🏦 LocalBankAPI

* uses: `makeTransaction(double value)`

---

#### ₿ CryptoGateway

* uses: `sendCryptoPayment(double amount)`

---

Each service:

* is NOT modifiable
* represents an external system or SDK
* has a different interface structure

---

### 🟣 Adapter Classes

Create adapters for each provider:

* `StripeAdapter`
* `BankAdapter`
* `CryptoAdapter`

Each adapter must:

* implement `PaymentProcessor`
* wrap its corresponding service
* translate `pay()` into provider-specific method calls
* use composition (NOT inheritance)

---

### 🟡 Checkout System (Client)

Create a `CheckoutService` or `Main` class that:

* depends ONLY on `PaymentProcessor`
* does NOT know which provider is used
* executes payments through unified interface

Example behavior:

```java id="m2x8qv"
paymentProcessor.pay(100);
```

---

## 🧩 Design Expectations

Your solution must:

* use **composition to wrap external services**
* eliminate direct dependency on external APIs
* isolate integration logic inside adapters
* follow **Open/Closed Principle**
* allow adding new payment providers without modifying checkout logic
* keep each adapter responsible for one conversion only

---

## 🔌 Key Design Mapping

| Component              | Role                        |
| ---------------------- | --------------------------- |
| Checkout System        | Client                      |
| PaymentProcessor       | Target Interface            |
| Stripe / Bank / Crypto | Adaptees                    |
| Adapters               | Translators between systems |

---

## ✅ Expected Outcome

A working system where:

* checkout uses only `PaymentProcessor`
* each payment provider is hidden behind an adapter
* adding a new gateway requires only a new adapter
* no changes are needed in checkout logic

---

## 🚀 Example Use Case (Conceptual Flow)

1. User selects payment method (Stripe / Bank / Crypto)
2. System selects corresponding adapter
3. Checkout calls:

```java id="p8v2wd"
paymentProcessor.pay(amount);
```

4. Adapter translates request internally
5. External service executes payment

---

## 🔁 Challenge Extension (Optional)

### 🔄 1. Add New Provider

Add a new payment system:

* PayPalService
* method: `executePayment(double amount)`

Create an adapter for it without modifying existing code.

---

### 🧾 2. Payment Logging Adapter

Enhance any adapter to log:

* payment start
* payment success
* payment failure

Without modifying checkout or existing services.

---

### 🧠 3. Dynamic Provider Switching

Modify system to switch providers at runtime based on:

* user selection
* configuration file
* strategy input

---

## 📌 Key Insight

This activity demonstrates the core purpose of the **Adapter Pattern**:

> It allows incompatible systems to work together without modifying their original code.

Most importantly:

* the backend depends only on abstractions
* external systems remain unchanged
* integration logic is isolated and reusable
