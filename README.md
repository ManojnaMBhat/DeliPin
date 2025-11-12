SmartDelivery - Route Optimization Spring Boot Backend
------------------------------------------------------

This is a minimal skeleton project implementing:
- JWT-based auth (register/login)
- Route computation service (simple greedy nearest-neighbor using a mock Google Maps client)
- Tracking endpoints for live location updates
- JPA repositories + H2 in-memory DB

To run:
1. Replace properties (google.maps.apiKey) if you intend to call real APIs.
2. Build: mvn clean package
3. Run: java -jar target/smartdelivery-0.0.1-SNAPSHOT.jar
4. H2 console: http://localhost:8080/h2-console (jdbc url: jdbc:h2:mem:smartdb)

Notes:
- This is a demo skeleton. GoogleMapsClient & DigipinClient are stubs and must be implemented for production use.
- JWT secret in application.properties is for demo only; use env vars or vault in production.
