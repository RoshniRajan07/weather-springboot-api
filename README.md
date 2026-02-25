Weather Data Processing API (Spring Boot)
This is a Spring Boot backend application that processes historical Delhi weather data from a CSV file and exposes REST APIs to retrieve filtered weather records and yearly temperature statistics.

The application:
Reads large weather CSV files
Cleans and stores data into MySQL database
Provides date-wise and month-wise weather retrieval
Calculates yearly minimum, median, and maximum temperature
Follows layered architecture (Controller → Service → Repository)

project structure:
<img width="560" height="776" alt="image" src="https://github.com/user-attachments/assets/9b950f9e-4d44-4936-aa2a-769a74103975" />

API Endpoints:
Load CSV Data (http://localhost:8080/weather/load)

Get Weather by Date(http://localhost:8080/weather/date/1996.11.01)

Get Weather by Month(http://localhost:8080/weather/month/11)

Get Yearly Temperature Statistics(http://localhost:8080/weather/stats/1997)

output:
<img width="946" height="486" alt="Screenshot 2026-02-25 113521" src="https://github.com/user-attachments/assets/a3c4f274-c7ae-4022-853f-6a66f2a6f63e" />
<img width="1919" height="1001" alt="Screenshot 2026-02-25 151727" src="https://github.com/user-attachments/assets/1d28009a-39e1-4f8d-8d81-06592a17edc6" />
<img width="1144" height="1049" alt="Screenshot 2026-02-25 152205" src="https://github.com/user-attachments/assets/d18dc203-2538-488b-ab82-421b5e42d4e5" />
<img width="902" height="516" alt="Screenshot 2026-02-25 201719" src="https://github.com/user-attachments/assets/c5ee6f55-069e-45c5-a63a-0a1cd73eab2f" />




