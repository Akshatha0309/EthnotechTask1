document.addEventListener("DOMContentLoaded", () => {

  /* 🔥 Explore button */
  document.querySelector(".hero-btn").addEventListener("click", () => {

    document.getElementById("places").scrollIntoView({
      behavior: "smooth"
    });

  });

  /* ✨ Scroll reveal */
  function revealElements() {

    const reveals = document.querySelectorAll(".reveal");

    reveals.forEach(element => {

      const windowHeight = window.innerHeight;
      const top = element.getBoundingClientRect().top;

      if (top < windowHeight - 100) {
        element.classList.add("active");
      }

    });

  }

  window.addEventListener("scroll", revealElements);

  revealElements();

});
setInterval(() => {

  document.querySelectorAll(".card img").forEach(img => {

    const current = img.src;

    img.src = current + "&" + new Date().getTime();

  });

}, 8000);