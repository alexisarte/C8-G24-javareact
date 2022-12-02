import React from "react";
import { CartList } from "../../CartList/CartList";

import products from "../../Records/ProductsLists/ProductLists.json";

import { Card, TextInput, Button , Select } from "flowbite-react";

import { useState } from "react";

import Datepicker from "react-tailwindcss-datepicker";

export const CartPage = () => {
    const [value, setValue] = useState({
        startDate: new Date(),
        endDate: new Date().setMonth(11)
    });

    const handleValueChange = (newValue) => {
        console.log("newValue:", newValue);
        setValue(newValue);
    }

   const holas = (e) => {
     console.log(e.target)
   }

   console.log("newValue:", value);
  return (
    <div className="container mx-auto my-16">
      <CartList products={products} />
        <div className="mt-8 flex gap-2 sm:gap-6 md:gap-10 max-sm:flex-wrap max-sm:justify-center">
          <Card className="basis-2/4 max-sm:basis-4/5">
            <form className="flex flex-col gap-4 " >
              <div>
                <TextInput
                  id="zipCode"
                  type="text"
                  placeholder="Ingresa tu codigo postal"
                  required={true}
                />
              </div>
              <div className="flex items-center gap-2">
              <Datepicker
                
                onChange={handleValueChange}
            />
             <div id="select">
  <div className="mb-2 block">
   
  </div>
  
</div>

              </div>
              <Select
    id="countries"
    required={true}
  >
    <option>
      Mañana (Entre las 9 y las 14hs)
    </option>
    <option>
      Tarde (Entre las 14 y las 19hs)
    </option>
    <option>
      Todo el día
    </option>
   
  </Select>
              <Button type="submit" color="dark">Continuar</Button>
            </form>
          </Card>
          <Card  className="basis-2/4 max-sm:basis-4/5 max-sm:mt-4"> 
            <p className="text-center"> Jueves 8 de diciembre 2022 entre las 9:00 hs y las 13:00 hs</p>
            <Button color="dark">Confirmar</Button>
          </Card>
        </div>
      </div>
    
  );
};
