import React from "react";
import { CartList } from "../../CartList/CartList";

import products from "../../Records/ProductsLists/ProductLists.json";

import { Card, TextInput, Button, Select } from "flowbite-react";

import { useState } from "react";

import Datepicker from "react-tailwindcss-datepicker";

import { useNavigate } from "react-router-dom";

import { useContext } from "react";
import CartContext from "../../CartContext";

export const CartPage = () => {

  const { cart, setCart, cartItems, setCartItems } = useContext(CartContext);

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

  const [storageShipping, setStorageShipping] = useState([]);

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

  function clickOn() {
    if (
      formValue.length >= 7 &&
      inDateItems.day.length >= 1 &&
      outDateItems.day.length >= 1 &&
      optionText !== undefined
    ) {
      setImpress(true);

      const objHola = [
        { ...storageShipping, optionText, formValue, inDateItems, outDateItems }
      ];

      sessionStorage.setItem("shippingSet", JSON.stringify(objHola));
    }
  }

  const handleValueChange = (newValue) => {
    setImpress(false);
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
    setImpress(false);
    setFormValue(event.target.value);
  };

  const handleChangeTurns = () => {
    setImpress(false);
    const turns = document.getElementById("turns");
    const textTurns = turns.options[turns.selectedIndex].text;
    setOptionText(textTurns);
  };

  const handleSubmitCart = (e) => {
    e.preventDefault();
    if (
      formValue.length >= 7 &&
      inDateItems.day.length >= 1 &&
      outDateItems.day.length >= 1 &&
      optionText !== undefined
    ) {
      setPrint(formValue);
    }
  };

  const navigate = useNavigate();

  const changePage = () => {
    if (impress) {
      navigate("/checkform");
    }
  };

  return (
    <div className="container mx-auto my-16">
      <CartList products={cart} />
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
            <Select id="turns" required={true} onChange={handleChangeTurns}>
              <option disabled selected>
                Selecciona un horario para la recogida
              </option>
              <option value="morning">Mañana (Entre las 9 y las 14hs)</option>
              <option value="evening">Tarde (Entre las 14 y las 19hs)</option>
              <option value="allDay">Todo el día</option>
            </Select>
            <Button
              type="submit"
              className="bg-[#37cbfa] hover:bg-[#269cc0]"
              onClick={clickOn}
            >
              Continuar
            </Button>
          </form>
        </Card>
        <Card className="basis-2/4 max-sm:basis-4/5 max-sm:mt-4">
          <div className="text-center">
            {impress ? (
              <div className="leading-8">
                <p>Tu codigo postal es el {print}</p>
                <p>
                  {`
                  Te llevaremos tu producto entre los dias ${inDateItems.day}
                  ${inDateItems.number}/${inDateItems.month}/${inDateItems.year} y el ${outDateItems.day}
                  ${outDateItems.number}/${outDateItems.month}/${outDateItems.year} entre los horarios de ${optionText} `}
                </p>
              </div>
            ) : (
              "Por favor completa el formulario"
            )}
          </div>
          <Button
            className="bg-[#37cbfa] hover:bg-[#269cc0]"
            type="submit"
            onClick={changePage}
          >
            Confirmar
          </Button>
        </Card>
      </div>
    </div>
  );
};
