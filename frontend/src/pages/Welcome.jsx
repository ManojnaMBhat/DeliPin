import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";

export const Welcome = () => {
  const navigate = useNavigate();

  // Auto-navigate after 2.5 seconds
  useEffect(() => {
    const timer = setTimeout(() => {
      navigate("/main"); // navigate to main page
    }, 2500);

    return () => clearTimeout(timer);
  }, [navigate]);

  // Scaled-down decorative circles, positioned mostly around edges
  const decorativeCircles = [
    { top: "5%", left: "80%", w: 8, h: 8, bg: "#1a77b7" },
    { top: "0%", left: "20%", w: 6, h: 6, bg: "#d8315b" },
    { top: "75%", left: "70%", w: 12, h: 12, bg: "#1a77b7" },
    { top: "25%", left: "0%", w: 5, h: 5, bg: "#ffba08" },
    { top: "60%", left: "90%", w: 5, h: 5, bg: "#3e92cc" },
    { top: "15%", left: "10%", w: 4, h: 4, bg: "#3e92cc" },
    { top: "0%", left: "50%", w: 14, h: 14, bg: "#ffba08" },
    { top: "55%", left: "-5%", w: 12, h: 12, bg: "#d8315b" },
    { top: "8%", left: "-5%", w: 6, h: 6, bg: "#d8315b" },
    { top: "35%", left: "80%", w: 3, h: 3, bg: "#3e92cc" },
    { top: "18%", left: "50%", w: 3, h: 3, bg: "#d8315b" },
    { top: "80%", left: "0%", w: 10, h: 10, bg: "#ffba08" },
    { top: "36%", left: "95%", w: 5, h: 5, bg: "#ffba08" },
    { top: "68%", left: "60%", w: 6, h: 6, bg: "#ffba08" },
    { top: "67%", left: "90%", w: 6, h: 6, bg: "#d8315b" },
    { top: "84%", left: "25%", w: 5, h: 5, bg: "#d8315b" },
    { top: "33%", left: "8%", w: 4, h: 4, bg: "#3e92cc" },
    { top: "79%", left: "60%", w: 3, h: 3, bg: "#ffba08" },
    { top: "77%", left: "12%", w: 2, h: 2, bg: "#3e92cc" },
    { top: "54%", left: "90%", w: 3, h: 3, bg: "#d8315b" },
    { top: "12%", left: "38%", w: 2, h: 2, bg: "#ffba08" },
    { top: "3%", left: "10%", w: 2, h: 2, bg: "#3e92cc" },
  ];

  return (
    <div className="bg-white w-full min-h-screen relative overflow-hidden">
      {/* Centered WELCOME text */}
      <h1 className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 
        text-4xl sm:text-5xl md:text-6xl lg:text-7xl font-normal text-[#29524a] text-center z-10">
        WELCOME
      </h1>

      {/* Decorative Circles */}
      {decorativeCircles.map((circle, index) => (
        <div
          key={index}
          className="absolute rounded-full"
          style={{
            top: circle.top,
            left: circle.left,
            width: `${circle.w}rem`,
            height: `${circle.h}rem`,
            backgroundColor: circle.bg,
            zIndex: 1, // behind the text
          }}
        />
      ))}
    </div>
  );
};
