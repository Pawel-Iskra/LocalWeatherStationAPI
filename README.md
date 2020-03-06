Technologies, patterns used in app:
<br> - Spring Boot (SpringWeb, SpringData),
<br> - Data Transfer Object
<br> - some GWT tests (in progress)
<br>
<br>Short description:
<br>While getting http request about weather condition in a specific city name, the app communicates with 3 different weather API's. It recevies the data, calculate the avarage values, add date to the IMDB - H2 and sends response using Data Transfer Object pattern.
<br>
<br>API provides some others methods:
<br> - get all locations (cities) stored in DB,
<br> - get all locations from DB grouped by conuntry,
<br> - get weather history from DB for a city,
<br> - delete location (city) with it's weather history.

