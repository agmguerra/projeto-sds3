import axios from "axios";
import Pagination from "components/pagination";
import Spinner from "components/Spinner";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";


const DataTable = () => {

    const [loaded, setLoaded] = useState(false)

    const [activePage, setActivePage] = useState(0)

    const [page, setPage] = useState<SalePage>({
        first: true,
        last: false,
        number: 0,
        totalPages: 0,
        totalElements: 0
    })

    useEffect(() => {
        setLoaded(false)
        axios.get(`${BASE_URL}/sales?page=${activePage}&size=20&sort=date,desc`)
            .then(response => {
                setLoaded(true)
                setPage(response.data)
            })
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [activePage])

    const changePage = (index: number) => {
        setActivePage(index)
    }


    return (
        <>
            <Spinner loaded={loaded} />
            <Pagination page={ page } onPageChange={changePage} />
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Vendedor</th>
                            <th>Clientes visitados</th>
                            <th>Negócios fechados</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        {page.content?.map(item => (
                            <tr key={item.id}>
                                <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                                <td>{item.seller.name}</td>
                                <td>{item.visited}</td>
                                <td>{item.deals}</td>
                                <td>{item.amount.toFixed(2)}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default DataTable;


