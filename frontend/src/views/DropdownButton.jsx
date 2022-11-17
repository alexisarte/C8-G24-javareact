import React from 'react';

function ButtonDropdown({ title, products }) {
  return (
    <div className="group">
      <button className=" bg-teal-200 p-5 group-hover:bg-teal-100">
        {title}
      </button>
      <div className="hidden absolute group-hover:block  bg-stone-400">
        {products.map((product, i) => (
          <a key={i} href="#" className="px-28 py-3 no-underline block hover:bg-stone-500">
            {product}
          </a>
        ))}
      </div>
    </div>
  );
}

export default ButtonDropdown;
