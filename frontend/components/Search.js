import React from "react";
import Map from "./Map";
import Drawer from "./Drawer";
import { useState } from "react";

export default function Search() {

  const [ displayEvent, setDisplayEvent ] = useState({});
  const [queryResult, setQueryResult] = useState([]);

  return (
    <>
      <Drawer setQueryRes={setQueryResult} display={displayEvent} />
      <Map setDisplay={setDisplayEvent} queryRes={queryResult} size={{ width: "100%", height: "788px" }} />
    </>
  );
}
