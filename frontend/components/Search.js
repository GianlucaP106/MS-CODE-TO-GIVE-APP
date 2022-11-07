import React from "react";
import Map from "./Map";
import Drawer from "./Drawer";
import { useState } from "react";

export default function Search() {

  const [ displayEvent, setDisplayEvent ] = useState({});

  return (
    <>
      <Drawer display={displayEvent} />
      <Map setDisplay={setDisplayEvent} size={{ width: "100%", height: "788px" }} />
    </>
  );
}
