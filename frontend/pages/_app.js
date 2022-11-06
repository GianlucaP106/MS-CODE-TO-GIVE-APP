import '../styles/globals.css'
// import '../assets/mdb.dark.min.css';
// import '../assets/mdb.dark.rtl.min.css';
// import '../assets/mdb.min.css';
// import '../assets/mdb.rtl.min.css';
import { useState } from "react";

function MyApp({ Component, pageProps }) {

  const [credentials, setCredentials] = useState({});
  return <Component cred={credentials} setCred={setCredentials} {...pageProps} />
}

export default MyApp
