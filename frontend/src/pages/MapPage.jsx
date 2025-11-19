import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import basemapImage from "../assets/images/Basemap image.png";
import logo from "../assets/vectors/logo.svg";

export const MapPage = () => {
  const location = useLocation();
  const item = location.state?.itemCoords;
  const delivery = location.state?.deliveryCoords;

  const [distance, setDistance] = useState("—");
  const [time, setTime] = useState("—");

  useEffect(() => {
    if (!item || !delivery) return;

    const computeRoute = async () => {
      try {
        const response = await fetch("http://localhost:8081/api/route/compute", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            start: item,
            deliveryIds: [1], // backend requirement
          }),
        });

        const data = await response.json();
        console.log("Route Response:", data);

        // Convert meters → km, seconds → minutes
        const distanceKm = (data.distanceMeters / 1000).toFixed(2);
        const durationMin = Math.ceil(data.durationSeconds / 60);

        setDistance(distanceKm + " km");
        setTime(durationMin + " min");

      } catch (err) {
        console.error("Error computing route", err);
      }
    };

    computeRoute();
  }, [item, delivery]);

  return (
    <div className="w-full h-screen relative bg-[#29524abf] overflow-hidden">
      <img src={basemapImage} alt="Map" className="w-full h-full object-cover" />

      {/* Delivery info panel */}
      <div className="absolute bottom-8 left-1/2 transform -translate-x-1/2 w-[90%] sm:w-[400px] bg-[#27453f] rounded-3xl p-6 flex flex-col gap-4 shadow-lg">
        <div className="flex flex-col sm:flex-row justify-between items-center gap-2">
          <span className="text-white text-lg sm:text-xl font-[Karrik-Regular]">Distance:</span>
          <span className="w-full sm:w-1/2 h-12 rounded-xl px-4 flex items-center justify-center bg-[#d9d9d9] text-[#27453f] text-lg font-[Karrik-Regular]">
            {distance}
          </span>
        </div>

        <div className="flex flex-col sm:flex-row justify-between items-center gap-2">
          <span className="text-white text-lg sm:text-xl font-[Karrik-Regular]">Time:</span>
          <span className="w-full sm:w-1/2 h-12 rounded-xl px-4 flex items-center justify-center bg-[#d9d9d9] text-[#27453f] text-lg font-[Karrik-Regular]">
            {time}
          </span>
        </div>
      </div>

      {/* Header */}
      <header className="absolute top-4 left-4 flex items-center gap-2">
        <img src={logo} alt="Logo" className="w-12 h-12 sm:w-14 sm:h-14" />
        <h1 className="font-[Jaro-Regular] text-3xl sm:text-4xl text-white">DELIPIN</h1>
      </header>
    </div>
  );
};
