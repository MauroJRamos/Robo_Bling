
import { useForm } from 'react-hook-form';

import './styles.css';

export type DadosAncoraFilterData = {
  dataInicio: string;
  dataFim: string;
};

type Props = {
  onSubmitFilter: (data: DadosAncoraFilterData) => void;
};



const DadosAncoraFiltro = ({ onSubmitFilter }: Props) => {

  const { register, handleSubmit, setValue } =
  useForm<DadosAncoraFilterData>();

const onSubmit = (formData: DadosAncoraFilterData) => {
  onSubmitFilter(formData);
};

const handleFormClear = () => {
  setValue('dataInicio','');
  setValue('dataFim','');
};

  return (
    <div className="base-card product-filter-container">
      <form onSubmit={handleSubmit(onSubmit)} className="product-filter-form">
        <div className="product-filter-bottom-container">
         <div className="product-filter-category-container">
          <input
           {...register('dataInicio')}
            type="text"
            className="form-control"
            placeholder="Data Inicio"
            name="dataInicio"
          />
          </div> 
        </div>
        <div className="product-filter-bottom-container">
          <div className="product-filter-category-container">
          <input
           {...register('dataFim')}
            type="text"
            className="form-control"
            placeholder="Data Fim"
            name="dataFim"
          />
          </div>
          <button className='product-filter-search-icon'>
            Source
           </button>
          <button
            onClick={handleFormClear}
            className="btn btn-outline-secondary btn-product-filter-clear"
          >
            LIMPAR<span className="btn-product-filter-word"> FILTRO</span>
          </button>
        </div>
      </form>
    </div>
  );
};

export default DadosAncoraFiltro;