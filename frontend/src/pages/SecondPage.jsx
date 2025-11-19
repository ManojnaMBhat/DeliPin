import React from "react";
import { useNavigate } from "react-router-dom";
import image1 from "../assets/images/image1.png";
import spvector from "../assets/vectors/spvector.svg";

export const SecondPage = () => {
  const navigate = useNavigate(); // navigation hook

  const decorativeCircles = [
    { top: "15%", left: "5%", size: "clamp(40px,12vw,120px)", bg: "#ffba08" },
    { top: "30%", left: "84%", size: "clamp(35px,10vw,100px)", bg: "#3e92cc" },
    { top: "55%", left: "72%", size: "clamp(35px,10vw,100px)", bg: "#d8315b" },
    { top: "70%", left: "10%", size: "clamp(30px,8vw,80px)", bg: "#1a77b7" },
    { top: "40%", left: "25%", size: "clamp(30px,8vw,80px)", bg: "#008000" },
    { top: "5%", left: "90%", size: "clamp(20px,5vw,60px)", bg: "#ff6f61" },
    { top: "2%", left: "60%", size: "clamp(28px,7vw,80px)", bg: "#6a0dad" },
    { top: "80%", left: "85%", size: "clamp(35px,10vw,100px)", bg: "#008000" },
  ];

  return (
    <main className="relative w-full min-h-screen bg-[#fcfffd] flex flex-col items-center justify-start px-4 overflow-hidden">
      {/* Decorative Circles */}
      {decorativeCircles.map((circle, index) => (
        <div
          key={index}
          className="absolute rounded-full border-2 border-white"
          style={{
            top: circle.top,
            left: circle.left,
            width: circle.size,
            height: circle.size,
            backgroundColor: circle.bg,
            transform: "translate(-50%, -50%)",
          }}
          aria-hidden="true"
        />
      ))}

      {/* Logo */}
      <img
        className="absolute top-4 left-1/2 transform -translate-x-1/2 w-[12vw] max-w-[60px] h-auto"
        alt="Delipin logo icon"
        src={spvector}
      />

      {/* Header */}
      <header className="mt-16 sm:mt-20 text-center font-[Jaro] text-[#29524a] text-[10vw] sm:text-5xl leading-tight">
        DELIPIN
      </header>

      {/* Main Image */}
      <img
        className="mt-6 w-[80vw] sm:w-[50vw] max-w-[400px] h-auto object-contain"
        alt="Delivery person holding packages"
        src={image1}
      />

      {/* Heading */}
      <h1 className="mt-6 text-center font-[HalenoirCompactText-Black-Regular] text-[#29524a] text-[6vw] sm:text-2xl sm:mt-10">
        Get delivery right at your doorstep.
      </h1>

      {/* Paragraph */}
      <p className="mt-4 text-center text-black font-[HalenoirCompactText-Black-Regular] text-[3.5vw] sm:text-sm sm:mt-6 max-w-[80vw] sm:max-w-[350px]">
        Your order will be delivered quickly by the deliver.
      </p>

      {/* Get Started Button */}
      <button
        onClick={() => navigate("/home")} // Navigate to HomePage
        className="mt-8 sm:mt-10 w-[80vw] sm:w-[338px] h-[12vw] sm:h-[59px] bg-[#29524a] rounded-lg cursor-pointer hover:bg-[#1f3e38] transition-colors focus:outline-none focus:ring-2 focus:ring-[#29524a] focus:ring-offset-2 flex items-center justify-center"
        aria-label="Get Started with Delipin"
      >
        <span className="text-white text-[4vw] sm:text-2xl font-[HalenoirCompactText-Black-Regular] text-center">
          Get Started
        </span>
      </button>
    </main>
  );
};
