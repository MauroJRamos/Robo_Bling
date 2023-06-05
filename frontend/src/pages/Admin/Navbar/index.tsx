import { NavLink } from "react-router-dom";
import "./styles.css";

const Navbar = () => {
  return (
    <nav className="admin-nav-container">
      <ul className="admin-nav-items-container">
        <li>
          <NavLink to="/admin/produtos" className="admin-nav-item">
            <p>Produtos</p>
          </NavLink>
        </li>
      
        <li>
          <NavLink to="/admin/usuarios" className="admin-nav-item">
            <p>Usuários</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/dados-ancora" className="admin-nav-item">
            <p>Dados Ancora</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/post-bling" className="admin-nav-item">
            <p>Post Bling</p>
          </NavLink>
        </li>
    
      </ul>
    </nav>
  );
};

export default Navbar;
