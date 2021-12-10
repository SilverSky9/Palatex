<template>
  <div class="container-fluid">
    <div class="row mr-2">
      <a
        href="#"
        class="col-sm-auto p-3 rounded-circle m-2 icon"
        title=""
        data-bs-toggle="tooltip"
        data-bs-placement="right"
        data-bs-original-title="Home"
      >
        <fa :icon="['fa', 'eraser']" size="2x" color="white" />
      </a>
      <div class="col-sm my-2 header">
        <span class="headerText py-0 pr-0 text-white">Palatex</span>
        <span class="text-secondary">Buying and Selling Latex Product</span>
      </div>
    </div>
    <div class="row positon-sticky">
      <div class="col-sm-auto">
        <div>
          <ul
            class="
              nav nav-pills nav-flush
              flex-sm-column flex-row flex-nowrap
              mb-auto
              mt-3
              mx-auto
              text-center
              align-items-center
            "
          >
            <li>
              <a
                href="#"
                class="nav-link py-3 px-2"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
                data-bs-original-title="Orders"
              >
                <fa class="item-link" :icon="['fa', 'user']" size="2x" />
              </a>
            </li>
            <li class="nav-item">
              <a
                href="#"
                class="nav-link py-3 px-2"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
                data-bs-original-title="Home"
              >
                <fa :icon="['fa', 'chart-bar']" size="2x" />
              </a>
            </li>
            <li>
              <a
                href="#"
                class="nav-link py-3 px-2"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
                data-bs-original-title="Dashboard"
              >
                <fa :icon="['fa', 'exchange-alt']" size="2x" />
              </a>
            </li>

            <li>
              <a
                href="#"
                class="nav-link py-3 px-2"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
                data-bs-original-title="Products"
              >
                <i class="bi-heart fs-1"></i>
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div class="col-sm min-vh-100">
        <Nuxt />
      </div>
    </div>
  </div>
</template>
<style >
html {
}
.nav-link {
  color: #9f9f9f;
}
.nav-link:hover {
  color: #000;
}
.header {
  border-radius: 10rem;
  font-family: 'Kanit';
  background-color: black;
}
.headerText {
  padding: 1rem;
  font-size: 2.6rem;
}
.icon {
  background-color: black;
}
</style>