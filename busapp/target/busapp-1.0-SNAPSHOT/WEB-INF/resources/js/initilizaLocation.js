const BASE_API_URL = '/busapp/api/location';
const STATION_API_URL = '/busapp/api/station';
const ROUTE_API_URL = '/busapp/api/route';

var province1 = document.getElementById("provinceCode");
var district1 = document.getElementById("districtCode");

var departure_p = document.getElementById("departure_p");
var departure_s = document.getElementById("departure_s");

var destination_p = document.getElementById("destination_p");
var destination_s = document.getElementById("destination_s");

var route = document.getElementById("route_trip");
var totalPrice = document.getElementById("totalPrice");

if (province1 !== null)
    province1.onchange = function () {
        const value = province1.value;
        const path = `${BASE_API_URL}/d/${value}`;

        if (value !== "")
            fetch(path, {
                method: "GET",
                responseType: "application/json"
            }).then(res => res.json()).then(data => {
                district1.length = 1;
                for (const d of data)
                    district1.options[district1.options.length] = new Option(d.name, d.code);
            });
        else {
            district1.length = 1;
        }
    };

if (departure_p !== null) {
    departure_p.onchange = function () {
        const value = departure_p.value;
        const path = `${STATION_API_URL}?province=${value}`;

        if (value !== "")
            fetch(path, {
                method: "GET",
                responseType: "application/json"
            }).then(res => res.json()).then(data => {
                console.log(data);
                console.log(path);
                departure_s.length = 1;
                for (const d of data)
                    departure_s.options[departure_s.options.length] = new Option(d.name, d.id);
            });
        else {
            departure_s.length = 1;
        }
    };
}

if (destination_p !== null) {
    destination_p.onchange = function () {
        const value = destination_p.value;
        const path = `${STATION_API_URL}?province=${value}`;

        if (value !== "")
            fetch(path, {
                method: "GET",
                responseType: "application/json"
            }).then(res => res.json()).then(data => {
                destination_s.length = 1;
                for (const d of data)
                    destination_s.options[destination_s.options.length] = new Option(d.name, d.id);
            });
        else {
            destination_s.length = 1;
        }
    };
}

if (route !== null) {

    route.onchange = function () {
        const value = route.value;
        const path = `${ROUTE_API_URL}/${value}`;
        console.log(path);
        if (value !== "") {
            fetch(path, {
                method: "GET",
                responseType: "application/json"
            }).then(res => res.json()).then(data => {
                totalPrice.value = data.price;
            });
        } else {
            console.log("a");
        }
    };
}
