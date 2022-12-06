import React from "react";
import CartProductsConfirmation from "../../CartProductsConfirmation/CartProductsConfirmation";

import CheckedShip from "../../CheckedShip/CheckedShip";

const InformationUserCheckout = () => {
  return (
    <div className="grid grid-cols-3  max-md:grid-cols-1">
      <div className="px-14 pt-20 pb-10 col-span-2  max-md:order-last bg-[#FFCC0A]">
        <CheckedShip />
      </div>
      <div className="grid justify-items-stretch px-12 items-center xl:mr-12">
        <CartProductsConfirmation />
      </div>
    </div>
  );
};

export default InformationUserCheckout;
