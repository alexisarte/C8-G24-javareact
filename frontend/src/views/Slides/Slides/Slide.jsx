import { Carousel } from "flowbite-react";

export const Slide = ({slides}) => { 
  return (
    <div className="h-56 sm:h-64 xl:h-80 2xl:h-96">
      <Carousel id="carrousel">
        {slides.map((slide) => {
          return (
            <div className={`flex h-full  dark:bg-gray-700 dark:text-white`} style={{backgroundColor: slide.bg}} key={slide.id}>
              <div className="flex justify-center items-center w-1/3 ">
                <p className="text-8xl max-md:text-4xl max-xl:text-6xl font-fontGotu ">
                  {slide.descuento}
                </p>
              </div>
              <div className="flex flex-col justify-center items-center w-2/3 font-fontGotu">
                <p className="text-3xl max-md:text-lg ">{slide.titulo1}</p>
                <p className="text-7xl max-xl:text-5xl max-md:text-3xl max-md:my-4 my-8 ">
                  {slide.titulo2}
                </p>
                <p className="text-3xl max-md:text-lg ">{slide.titulo3}</p>
              </div>
              <div className="w-1/3 flex">
                <img src={slide.url} alt="imagen mascota" />
              </div>
            </div>
          );
        })}
      </Carousel>
    </div>
  );
};
