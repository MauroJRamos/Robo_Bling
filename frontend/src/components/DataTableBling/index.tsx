import axios from "axios";
import Pagination from "components/Pagination";
import ProdutoFiltro , { ProductFilterData } from "components/ProdutoFiltro";
import { useEffect, useState } from "react";
import { BlingPage } from "types/postBling";
import { formatLocalDate } from "util/format";
import { BASE_URL } from "util/requests";


type ControlComponentsData = {
  activePage: number;
  filterData: ProductFilterData;
};


const DataTableBling = () => {
  
  

  //const [activePage, setActivePage] = useState(0);
  const [page, setPage] = useState<BlingPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  const [controlComponentsData, setControlComponentsData] =
    useState<ControlComponentsData>({
      activePage: 0,
      filterData: { codigo: '' },
    });

  const handleSubmitFilter = (data: ProductFilterData) => {
    setControlComponentsData({ activePage: 0, filterData: data });   
  };

  const handlePageChange = (pageNumber: number) => {
    setControlComponentsData({ activePage: pageNumber, filterData: controlComponentsData.filterData});
  };

  useEffect(() => {
    axios
      .get(
        `${BASE_URL}/post_bling?page=${controlComponentsData.activePage}&size=12&sort=datRequest`
      )
      .then((response) => {
        setPage(response.data);
        
      });
  }, [ controlComponentsData]); 


  return (
    <>
      <div className="product-crud-bar-container">
        <ProdutoFiltro onSubmitFilter={handleSubmitFilter}/>
      </div>
      
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="row">Codigo</th>
              <th scope="row">Status Request</th>
              <th scope="row">Payload Request</th>
              <th scope="row">Data Request</th>
             
            </tr>
          </thead>
          <tbody>
            {page.content?.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.status_request}</td>
                <td>{item.payload_request}</td>
                <td>{formatLocalDate(item.datRequest, "dd/MM/yyyy")}</td>
               
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <Pagination  forcePage={page?.number}
        pageCount={page ? page.totalPages : 0}
        range={3}
        onChange={handlePageChange} />
    </>
  );
};

export default DataTableBling;
