import React from 'react';

function ButtonDropdown({ title }) {
  return (
    <div className="group ">
      <button className="rounded-full bg-teal-200 p-1 hover:opacity-75">
        {title}
      </button>
      <div className="hidden absolute group-hover:block">
        <a href="#" className="px-12 py-16 no-underline block">
          Link 1
        </a>
        <a href="#" className="px-12 py-16 no-underline block">
          Link 2
        </a>
        <a href="#" className="px-12 py-16 no-underline block">
          Link 3
        </a>
      </div>
    </div>
  );
}

export default ButtonDropdown;
