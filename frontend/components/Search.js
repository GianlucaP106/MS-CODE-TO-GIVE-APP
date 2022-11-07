import React from "react";
import Map from "./Map";
import Drawer from "./Drawer";

export default function Search() {
  return (
    <>
      <Drawer />
      <Map size={{ width: "100%", height: "788px" }} />
    </>
  );
}
