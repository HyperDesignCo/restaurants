# Restaurant SaaS — Android App

A white-label food ordering & delivery Android application with multi-brand support and offline-first resilience.

---

## Features

### Authentication & Onboarding
- [ ] Phone number login with OTP verification
- [ ] Google OAuth sign-in
- [ ] Facebook OAuth sign-in
- [ ] 3-step forgot password flow — phone → OTP → reset password
- [ ] Animated splash screen with auto-navigation to onboarding or home
- [ ] Session persistence across app restarts

---

### Ordering Experience
- [ ] Delivery or in-store pickup mode selection
- [ ] Cascading city / area / branch picker
- [ ] Home feed with auto-scrolling promotional banners
- [ ] Category filter chips (horizontal scroll)
- [ ] Featured items section (horizontal scroll)
- [ ] Full menu list (vertical)
- [ ] Item detail screen with dynamic single-select and multi-select option groups
- [ ] Special instructions textarea per item
- [ ] Live price calculation as options are selected
- [ ] Real-time cart with per-item quantity controls
- [ ] Inline special requests per cart item
- [ ] Itemized order summary — subtotal, VAT, delivery fees

---

### Checkout & Payments
- [ ] Promo code input with instant discount reflection
- [ ] Cash on Delivery payment method
- [ ] Credit / Debit card payment method
- [ ] Google Pay support
- [ ] Animated card entry form with live flip preview
- [ ] Automatic card-type detection (Visa, Mastercard, Mada)
- [ ] Save card toggle for returning users

---

### Address Management
- [ ] Embedded map with draggable pin for location selection
- [ ] One-tap GPS current location detection
- [ ] Address form — neighborhood, street, building, floor, apartment, landmark
- [ ] Address label tagging — Home / Work / Other
- [ ] Edit and delete saved addresses
- [ ] Set default address

---

###  Order Tracking
- [ ] Active orders with animated progress stepper — Confirmed → Preparing → On the Way → Delivered
- [ ] Full order history with Delivered / Cancelled status badges
- [ ] One-tap reorder from history
- [ ] Dedicated tracking screen per active order

---

###  Profile & Settings
- [ ] Profile editing with avatar upload
- [ ] Language toggle — English / Arabic
- [ ] Light / Dark mode toggle
- [ ] Push notification preferences
- [ ] In-app contact form — complaint, suggestion, inquiry, other
- [ ] App sharing prompt
- [ ] Store rating prompt
- [ ] Privacy policy and terms screens
- [ ] About us screen
- [ ] Account deletion
- [ ] Logout

---

###  Multi-Brand Theming
- [ ] 3 brand color variants — Amber · Cobalt · Emerald — from a single codebase
- [ ] Light and Dark mode on every screen
- [ ] Full RTL layout mirroring for Arabic
- [ ] Arabic (Cairo) and English (Poppins) font switching
- [ ] Eastern-Arabic numeral support for Arabic locale

---

###  Offline-First & Connectivity
- [ ] Offline-first architecture — all reads served from local cache
- [ ] Real-time network state monitoring
- [ ] Background sync queue — failed writes replayed automatically on reconnection
- [ ] Graceful degraded UI — read-only mode and pending-sync indicators when offline
- [ ] Server-wins conflict resolution on sync
