import React from "react";
import { CartList } from "../../CartList/CartList";

import products from "../../Records/ProductsLists/ProductLists.json";

import { Card, TextInput, Button, Select } from "flowbite-react";

import { useState } from "react";

import Datepicker from "react-tailwindcss-datepicker";

export const CartPage = () => {
  const [optionText, setOptionText] = useState();
  const [print, setPrint] = useState();
  const [impress, setImpress] = useState();
  const [value, setValue] = useState({
    startDate: new Date(),
    endDate: new Date().setMonth(11)
  });

  const [formValue, setFormValue] = useState({
    form: ""
  });

  const [inDateItems, setInDateItems] = useState({
    number: "",
    month: "",
    day: "",
    year: ""
  });

  const [outDateItems, setOutDateItems] = useState({
    number: "",
    month: "",
    day: "",
    year: ""
  });

  const dias = [
    "domingo",
    "lunes",
    "martes",
    "miércoles",
    "jueves",
    "viernes",
    "sábado",
    "domingo"
  ];
  
function clickOn(){
  setImpress(true);
}

  const handleValueChange = (newValue) => {
    setImpress(false)
    setValue(newValue);
    
    //Introducir valores de inicio
    const numberDayIn = new Date(newValue.startDate).getDay();
    const nameDayIn = dias[numberDayIn];

    const dateIn = newValue.startDate.split("-");

     Object.assign(inDateItems, {
      number: dateIn[2],
      day: nameDayIn,
      month: dateIn[1],
      year: dateIn[0]
    });

    //Introducir valores de salida
    const numberDayOut = new Date(newValue.endDate).getDay();
    const nameDayOut = dias[numberDayOut];

    const dateOut = newValue.endDate.split("-");

    Object.assign(outDateItems, {
      number: dateOut[2],
      day: nameDayOut,
      month: dateOut[1],
      year: dateOut[0]
    });

  };

  const handleChangeForm = (event) => {
    event.preventDefault();
    setImpress(false)
    setFormValue(event.target.value);
  };
 
  const handleSubmitCart = (e) => {
    e.preventDefault();

    const turns = document.getElementById("turns");
    const textTurns = turns.options[turns.selectedIndex].text;
   
    if (formValue.length >= 7 && inDateItems.day.length >= 1 && outDateItems.day.length >= 1) {
      
      setPrint(formValue);
      setOptionText(textTurns);
      
    }
  };

  return (
    <div className="container mx-auto my-16">
      <CartList products={products} />
      <div className="mt-8 flex gap-2 sm:gap-6 md:gap-10 max-sm:flex-wrap max-sm:justify-center">
        <Card className="basis-2/4 max-sm:basis-4/5">
          <form className="flex flex-col gap-4" onSubmit={handleSubmitCart}>
            <div>
              <TextInput
                maxLength={8}
                id="zipCode"
                type="text"
                placeholder="Ingresa tu codigo postal"
                required={true}
                name="zipCode"
                onChange={handleChangeForm}
              />
            </div>
            <div className="flex items-center">
              <Datepicker onChange={handleValueChange} value={value} />
            </div>
            <Select id="turns" required={true}>
              <option value="morning">Mañana (Entre las 9 y las 14hs)</option>
              <option value="evening">Tarde (Entre las 14 y las 19hs)</option>
              <option value="allDay">Todo el día</option>
            </Select>
            <Button type="submit" color="dark" onClick={clickOn}>
              Continuar
            </Button>
          </form>
        </Card>
        <Card className="basis-2/4 max-sm:basis-4/5 max-sm:mt-4">
          <div className="text-center">
            {impress ? (
              <div>
                <p>Tu codigo postal es el {print}</p>
                <p>{`
                  Te llevaremos tu producto entre los dias ${inDateItems.day}
                  ${inDateItems.number}/${inDateItems.month}/${inDateItems.year} y el ${outDateItems.day}
                  ${outDateItems.number}/${outDateItems.month}/${outDateItems.year} entre los horarios de ${optionText} `}
                </p>
              </div>
            ) : (
              "Por favor completa el formulario"
            )}
          </div>
          <Button color="dark" type="submit">
            Confirmar
          </Button>
        </Card>
      </div>
    </div>
  );
};
