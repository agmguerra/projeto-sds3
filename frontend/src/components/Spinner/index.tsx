
type Props = {
    loaded: boolean;
}

const Spinner = ({ loaded }: Props) => {
    if (!loaded) {
        return (
                <div className="text-center">
                    <div className="spinner-border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </div>
                </div>
        )
    }
    return (<></>);
}

export default Spinner;