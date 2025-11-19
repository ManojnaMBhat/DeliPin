import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import mainIcon from "../assets/vectors/vectors.svg";

export const MainPage = () => {
  const navigate = useNavigate(); // navigation hook

  // Auto-navigate after 5 seconds
  useEffect(() => {
    const timer = setTimeout(() => {
      navigate("/second"); // navigate to SecondPage
    }, 3000);

    return () => clearTimeout(timer);
  }, [navigate]);

  const decorativeCircles = [
    { top: "5%", left: "5%", size: "5vw", bg: "bg-pink-500" },
    { top: "10%", left: "50%", size: "3vw", bg: "bg-blue-800" },
    { top: "8%", left: "90%", size: "6vw", bg: "bg-purple-600" },
    { top: "85%", left: "10%", size: "5vw", bg: "bg-red-500" },
    { top: "80%", left: "50%", size: "4vw", bg: "bg-blue-500" },
    { top: "90%", left: "85%", size: "6vw", bg: "bg-green-400" },
    { top: "35%", left: "15%", size: "4vw", bg: "bg-pink-400" },
    { top: "60%", left: "10%", size: "3vw", bg: "bg-yellow-300" },
    { top: "40%", left: "85%", size: "5vw", bg: "bg-purple-400" },
    { top: "65%", left: "80%", size: "3vw", bg: "bg-blue-400" },
    { top: "20%", left: "75%", size: "4vw", bg: "bg-indigo-500" },
    { top: "50%", left: "60%", size: "4vw", bg: "bg-red-400" },
    { top: "70%", left: "40%", size: "3vw", bg: "bg-green-500" },
  ];

  return (
    <main className="relative w-full min-h-screen bg-green-900 overflow-hidden flex flex-col items-center justify-center">
      {/* Decorative Circles */}
      <div aria-hidden="true" className="absolute inset-0">
        {decorativeCircles.map((circle, index) => (
          <div
            key={index}
            className={`absolute ${circle.bg} rounded-full`}
            style={{
              top: circle.top,
              left: circle.left,
              width: circle.size,
              height: circle.size,
              transform: "translate(-50%, -50%)",
            }}
          />
        ))}
      </div>

      {/* Content */}
      <div className="flex flex-col sm:flex-row items-center justify-center gap-6 sm:gap-12 mt-16 px-4 w-full max-w-5xl">
        {/* Image */}
        <div className="flex-shrink-0">
          <img
            src={mainIcon}
            alt="Delivery Icon"
            className="w-[50vw] sm:w-[25vw] max-w-[200px]"
          />
        </div>

        {/* Text */}
        <div className="text-white flex flex-col items-start relative">
          <h1
            className="text-[12vw] sm:text-[6vw] font-bold"
            style={{ fontFamily: "'Jaro'" }}
          >
            DELI
          </h1>
          <h1
            className="text-[14vw] sm:text-[7vw] font-bold"
            style={{ fontFamily: "'Jaro'" }}
          >
            PIN.
          </h1>
        </div>
      </div>
    </main>
  );
};
