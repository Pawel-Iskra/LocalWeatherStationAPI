Video sample of working:<br>
        -> sample 1: video sample of working : <a href="https://github.com/Pawel-Iskra/Media/blob/master/weather_station_1.mp4">Sample_1</a><br>
        -> sample 2: video sample of working : <a href="https://github.com/Pawel-Iskra/Media/blob/master/weather_station_2.mp4">Sample_2</a><br>

<br>Short description:
<br>After getting Http request about weather condition for a specific city name, the app communicates with 3 different weather stations API's. It recevies the data, calculate the avarage values, add data to the IMDB - H2 and sends response using Data Transfer Object pattern.
<br>

<br><br>Technologies, patterns used in app:
<br> - Spring Boot (SpringWeb, SpringData),
<br> - Rest API,
<br> - Data Transfer Object pattern,
<br> - GWT tests (in progress)
<br>

<br>API provides some others methods:
<br> - get all locations (cities) stored in DB,
<br> - get all locations from DB grouped by country,
<br> - get weather history from DB for a location (city),
<br> - delete location from DB (city) with it's weather history.

