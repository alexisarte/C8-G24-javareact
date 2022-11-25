import { Dropdown } from "flowbite-react";
import { Avatar, Label, TextInput, Checkbox, Button } from "flowbite-react";
import user from "../../assets/vectors/user.svg";

const Account = () => {
  return (
    <>
      <Dropdown
        label={
          <>
            <Avatar alt="User settings" img={user} rounded={true} />
            <div>
              <p>MI CUENTA</p>
            </div>
          </>
        }
        class=" hover:bg-yellow-200 rounded"
      >
        <Dropdown.Header>
          <span className="block text-sm">Conectarme a mi cuenta</span>
          <span className="block text-sm font-medium truncate">
            Ingresa tu e-mail y tu contraseña
          </span>
        </Dropdown.Header>
        <form className="flex flex-col gap-4 mx-4">
          <div>
           
            <TextInput
              id="email1"
              type="email"
              placeholder="E-Mail"
              required={true}
            />
          </div>
          <div>
           
            <TextInput id="password1" type="password" placeholder="Contraseña" required={true} />
          </div>
          <div className="flex items-center gap-2">
            <Checkbox id="remember" />
            <Label htmlFor="remember">Remember me</Label>
          </div>
          <Button type="submit" color="dark">ENTRAR</Button>
          <span className="block text-sm">¿Nuevo cliente? <span>Crear cuenta</span></span>
          <span className="block text-sm font-medium truncate">
            ¿Olvidaste tu contraseña? <span>Recuperar contraseña</span> 
          </span>
        </form>
      </Dropdown>
    </>
  );
};

export default Account;
