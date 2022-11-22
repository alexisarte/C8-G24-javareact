/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./index.html", "./src/**/*.{js,jsx}"],
  theme: {
    extend: {fontFamily: {
      "logoFont":['Fruktur', 'cursive'],
      "fontGafata":['Gafata', 'sans-serif'],
      "fontGamja": ['Gamja Flower', 'cursive'],
      "fontGotu":['Gotu', 'sans-serif'],
      "fontFredoka":['Fredoka One', 'cursive'],
      "fontFresca": ['Fresca', 'sans-serif'],
      "fontFuzzy": ['Fuzzy Bubbles', 'cursive'],
      "fontGaldeano": ['Galdeano', 'sans-serif']
    }},
    backgroundImage:  {
      'onboarding-background': "url('../assets/cat-dog-background.png')",
    },
  },
  plugins: [],
};
