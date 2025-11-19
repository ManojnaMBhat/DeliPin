import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import logo from "../assets/vectors/logo.svg";

export const HomePage = () => {
  const navigate = useNavigate();
  const [pickupPincode, setPickupPincode] = useState("");
  const [deliveryPincode, setDeliveryPincode] = useState("");

  const instructionSteps = [
    "Enter your 10-character Digipin",
    "View the location on the map",
    "Track your location in real-time",
    "Provides the shortest path to reach",
  ];

  const handlePickupChange = (e) => {
    const value = e.target.value.replace(/[^a-zA-Z0-9]/g, "").slice(0, 10);
    setPickupPincode(value);
  };

  const handleDeliveryChange = (e) => {
    const value = e.target.value.replace(/[^a-zA-Z0-9]/g, "").slice(0, 10);
    setDeliveryPincode(value);
  };

  const getDecodedPins = async () => {
    try {
      const response = await fetch("http://localhost:8081/api/digipin/decode", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          itemDigipin: pickupPincode,
          deliveryDigipin: deliveryPincode,
        }),
      });

      const data = await response.json();
      console.log("Backend Response:", data);

      navigate("/map", {
        state: {
          itemCoords: data.itemLocation,
          deliveryCoords: data.deliveryLocation,
          distance: data.distance,      // ✔ FIX
          time: data.time              // ✔ FIX
        },
      });

    } catch (error) {
      console.error("Error decoding pins:", error);
    }
  };

  return (
    <div className="bg-[#29524a] min-h-screen w-full relative flex flex-col items-center px-4 sm:px-8 py-6">

      <header className="flex justify-center items-center w-full mb-6 relative">
        <div className="text-[#ffba08] font-[Jaro-Regular] text-3xl sm:text-4xl">
          DELIPIN
        </div>
        <img src={logo} alt="Delipin Logo" className="w-8 sm:w-12 h-auto ml-2" />
      </header>

      <section className="w-full max-w-4xl text-white mb-12">
        <h2 className="text-2xl sm:text-2xl font-[Karrik-Regular] mb-3 text-center sm:text-left">
          How it works
        </h2>
        <ol className="list-decimal list-inside space-y-2 text-lg sm:text-xl px-2 sm:px-0">
          {instructionSteps.map((step, index) => (
            <li key={index}>{step}</li>
          ))}
        </ol>
      </section>

      <div className="w-full max-w-4xl flex flex-col sm:flex-row gap-6 sm:gap-12 mb-16 mt-6">

        <div className="relative flex-1">
          <div className="bg-[#d9d9d9] rounded-2xl w-full h-20 sm:h-24 absolute inset-0" />
          <div className="bg-[#29524a] rounded-2xl w-full h-20 sm:h-24 absolute inset-0" />
          <input
            type="text"
            value={pickupPincode}
            onChange={handlePickupChange}
            placeholder="Enter 10-character Digipin"
            maxLength={10}
            className="relative z-10 w-full px-4 py-4 sm:py-5 rounded-2xl text-center text-lg sm:text-xl placeholder:text-[#00000047] font-[Karrik-Regular] text-[#000000]"
          />
          <div className="absolute -top-9 left-1/3 transform -translate-x-1/2 text-white font-[Karrik-Regular] text-lg sm:text-xl">
            ENTER PICKUP DIGIPIN
          </div>
        </div>

        <div className="relative flex-1">
          <div className="bg-[#d9d9d9] rounded-2xl w-full h-20 sm:h-24 absolute inset-0" />
          <div className="bg-[#29524a] rounded-2xl w-full h-20 sm:h-24 absolute inset-0" />
          <input
            type="text"
            value={deliveryPincode}
            onChange={handleDeliveryChange}
            placeholder="Enter 10-character Digipin"
            maxLength={10}
            className="relative z-10 w-full px-4 py-4 sm:py-5 rounded-2xl text-center text-lg sm:text-xl placeholder:text-[#00000047] font-[Karrik-Regular] text-[#000000]"
          />
          <div className="absolute -top-9 left-1/3 transform -translate-x-1/2 text-white font-[Karrik-Regular] text-lg sm:text-xl">
            ENTER DELIVERY DIGIPIN
          </div>
        </div>

      </div>

      <button
        onClick={getDecodedPins}
        className="w-[80%] sm:w-80 h-15 sm:h-14 bg-[#ffba08] rounded-lg text-[#29524a] font-[Karrik-Regular] text-lg sm:text-xl hover:bg-[#e0a800] transition-colors mt-6"
      >
        Order Now
      </button>
    </div>
  );
};
